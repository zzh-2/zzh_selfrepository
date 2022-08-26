package zzh;

import bean.ContentBean;
import com.alibaba.excel.EasyExcel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.CustomCellWriteHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnjukeSpider {
    public static void main(String[] args) throws IOException, InterruptedException {
        String excel = "D:\\toy.xlsx";
        EasyExcel.write(excel, ContentBean.class).sheet("ajk")
                .registerWriteHandler(new CustomCellWriteHandler())
                .doWrite(new AnjukeSpider().write( "花都"));
        //
    }

    public List<ContentBean> write(String subCity) throws IOException, InterruptedException {
        ArrayList<ContentBean> contents = new ArrayList<ContentBean>();
        for(int i=1; i<2; i++){
            String request = "https://gz.fang.anjuke.com/loupan/all/p" + Integer.toString(i) + "/s?kw=" + subCity;
            System.out.println(request);

            //获取需要解析的网页的html页面
            Document document = Jsoup.connect(request).get();
            //获取到html中的主列表
            Element element = document.getElementsByClass("key-list imglazyload").get(0);
            //获取到主列表中的所有子项集合，一个子项代表一个房源的信息
            Elements elements = element.getElementsByClass("item-mod");

            //遍历子项集合，解析每个子项中想要爬到的信息，并放入到contents集合中
            for (Element e : elements) {
                ContentBean cb = new ContentBean();

                String title = e.getElementsByClass("lp-name").eq(0).text();
                String img = e.getElementsByTag("img").eq(0).attr("src");

                String type = e.getElementsByClass("huxing").text();
                String size = e.getElementsByClass("building-area").eq(0).text();
                String addr = e.getElementsByClass("address").eq(0).text();
                String price = e.getElementsByClass("price").eq(0).text();

                cb.setTitle(title);
                cb.setImg(img);
                cb.setType(type);
                cb.setSize(size);
                cb.setAddress(addr);
                cb.setPrice(price);
                contents.add(cb);

                //这里是想设置一个时间间隔随便防一下爬虫的，但不知道为何间隔时间与设置的不一样
                Thread.sleep(20);
            }
        }
        return contents;
    }
}
