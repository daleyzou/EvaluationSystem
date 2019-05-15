package cc.daleyzou.patient.rest;

import cc.daleyzou.patient.domain.Instance;

public class AjaxInstance {

    private Boolean success;

    private Instance instance;

    public AjaxInstance(Boolean success, Instance instance) {
        this.success = success;
        this.instance = instance;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

}
