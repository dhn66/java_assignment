public class MachineResource extends Resource{

    private String machine_description;
    private float kw_per_hour;

    // - - - - - - - - - - - - - - -
    //
    //      CONSTRUCTORS
    //
    // - - - - - - - - - - - - - - -

    // default Constructor
    public MachineResource(){
        machine_description = "";
        kw_per_hour = 0.0f;
    }

    // constructor with MachineResource members
    // ( machine_description , killowats per hour )
    public MachineResource(String description , float kwh){
        machine_description = description;
        kw_per_hour = kwh;
    }


    // - - - - - - - - - - - - - - -
    //
    //      GET FUNCTIONS
    //
    // - - - - - - - - - - - - - - -

    public String toString()
    {
        String info = super.toString() +
                      "    Description : "+machine_description+"\n"+
                      "    KWH : "+kw_per_hour+"\n";
        return info;
    }

    public String getDescription(){
        return machine_description;
    }

    public float getKwh(){
        return kw_per_hour;
    }



}
