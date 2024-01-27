public class ProductionOrder{

    static int production_orders_count = 0;

    static final float KWH_CHARGE = 0.089f;       // per kwh
    static final float SETUP_TIME_CHARGE = 0.45f; // per minute

    private float kw_per_hour;
    private float setup_time;

    private int Id;
    private String description;
    private float production_cost;


    // - - - - - - - - - - - - - - -
    //
    //      CONSTRUCTORS
    //
    // - - - - - - - - - - - - - - -

    // default constructor
    public ProductionOrder(){

        production_cost = 0.0f;
        description = "";

        Id = production_orders_count;
        production_orders_count++;
    }

    // constructor with ProductionOrder member ( description )
    public ProductionOrder(String description){

        this.description = description;
        production_cost = 0.0f;

        Id = production_orders_count;
        production_orders_count++;
    }

    // - - - - - - - - - - - - - - -
    //
    //      FUNCTIONS
    //
    // - - - - - - - - - - - - - - -

    // calculate production cost based on killowats per hour and setup time
    public void calculateProductionCost(){

    }

    // - - - - - - - - - - - - - - -
    //
    //      GET FUNCTIONS
    //
    // - - - - - - - - - - - - - - -

    public String toString(){
        String info =
                "    Id : "+Id+"\n"+
                "    Description : "+description+"\n";

        return info;
    }

    public int getId(){
        return Id;
    }

    public String getDescription(){
        return description;
    }

    public float getProductionCost(){
        return production_cost;
    }

}
