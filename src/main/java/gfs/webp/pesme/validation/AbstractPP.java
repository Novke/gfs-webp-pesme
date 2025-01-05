package gfs.webp.pesme.validation;

import gfs.webp.pesme.exceptions.SysException;

public abstract class AbstractPP {
    protected final void deny(String reason){
        deny(reason, 400); //400 = BAD REQUEST
    }

    protected final void deny(String reason, int code){
        throw new SysException(reason, code);
    }
}
