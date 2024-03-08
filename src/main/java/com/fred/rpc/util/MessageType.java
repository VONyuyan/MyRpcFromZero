package com.fred.rpc.util;

import lombok.AllArgsConstructor;

/**
 * ClassName: MessageType
 * Package: com.fred.rpc.util
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/8 15:09
 * @Version 1.0
 */
@AllArgsConstructor
public enum MessageType {
    REQUEST(0),RESPONSE(1);
    private int code;
    public int getCode() {
        return code;
    }
}
