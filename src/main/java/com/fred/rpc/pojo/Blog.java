package com.fred.rpc.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: Blog
 * Package: com.fred.rpc.pojo
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/6 14:24
 * @Version 1.0
 */
// pojo类
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Blog implements Serializable {
    private Integer id;
    private Integer useId;
    private String title;
}
