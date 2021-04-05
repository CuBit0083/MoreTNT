package org.cubit.moretnt.moretnt;

import java.util.HashMap;
import java.util.Map;

public class MoreTNTManager {

    private Map<String , MoreTNT> moreTNTs;

    public MoreTNTManager() {
        this.moreTNTs = new HashMap<>();
    }
    public void register(String name , MoreTNT moreTNT) {
        if (this.moreTNTs == null || moreTNT == null) {
            return;
        }
        this.moreTNTs.put(name , moreTNT);
    }

    public MoreTNT getMoreTNT(String name) {
        return this.moreTNTs.get(name);
    }


}
