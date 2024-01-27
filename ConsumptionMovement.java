public class ConsumptionMovement{


    private float consumption_cost;
    private ProductionOrder productionOrder;
    private String date;
    private Resource resource;
    private float consumption_time;

    // - - - - - - - - - - - - - - -
    //
    //      CONSTRUCTORS
    //
    // - - - - - - - - - - - - - - -

    public ConsumptionMovement(){
        productionOrder = null;
        date = "";
        resource = null;
        consumption_time = 0.0f;
        consumption_cost = 0.0f;
    }

    public ConsumptionMovement(ProductionOrder order , String date , Resource rsc  , float time){
        productionOrder = order;
        this.date = date;
        resource = rsc;
        consumption_time = time;
        consumption_cost = 0.0f;
    }

    // - - - - - - - - - - - - - - -
    //
    //      GET FUNCTIONS
    //
    // - - - - - - - - - - - - - - -

    public String toString(){
        String info = "  _ProductionOrder:"+"\n"+
                productionOrder.toString()+"\n"+
                "  _Resource:"+"\n"+
                resource.toString()+"\n"+
                "    Date : "+date +"\n"+
                "    Consumption Time : "+consumption_time+"\n";
        return info;
    }

    public int getProductionOrderId(){
        return productionOrder.getId();
    }

    public String getDate(){
        return date;
    }

    public Resource getResource(){
        return resource;
    }

    public float getConsumptionTime(){
        return consumption_time;
    }

    public void calculateConsumptionCost(){
        consumption_cost = 0.0f;
        if(resource instanceof HumanResource)
            consumption_cost += resource.getWage() * consumption_time/60.0f;
        else if(resource instanceof AutoMachine)
            consumption_cost += resource.getKwh() * 0.089f;
        else if(resource instanceof ManualMachine)
            consumption_cost += resource.getKwh() * 0.089f + resource.getSetupTime() * 0.45f;
    }


    public float getConsumptionCost(){
        calculateConsumptionCost();
        return consumption_cost;
    }
}
