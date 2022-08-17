package bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//使用@Data注解后可以省去自己书写Get/Set方法
@Data
//使用@NoArgsConstructor注解会为类提供一个无参的构造方法
@NoArgsConstructor
//使用@AllArgsConstructor注解会为类提供一个全参的构造方法
@AllArgsConstructor
public class ContentBean {
    @ExcelProperty("标题")
    private String title;

    @ExcelProperty("预览图")
    private String img;

    @ExcelProperty("户型")
    private String type;

    @ExcelProperty("大小")
    private String size;

    @ExcelProperty("地址")
    private String address;

    @ExcelProperty("单价")
    private String price;
}
