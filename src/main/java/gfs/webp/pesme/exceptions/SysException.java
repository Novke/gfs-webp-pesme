package gfs.webp.pesme.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SysException extends RuntimeException{

    private final int code;

    public SysException(String message) {
        super(message);
        code = 400;
    }
    public SysException(String message, int code) {
        super(message);
        this.code = code;
    }

    public SysException(String message, Throwable cause) {
        super(message, cause);
        code = 400;
    }

    public SysException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public SysException(Throwable cause) {
        super(cause);
        code = 400;
    }

    public SysException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }
}
