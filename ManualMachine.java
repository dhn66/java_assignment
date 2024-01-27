public class ManualMachine extends MachineResource{

    private float setup_time;

    // - - - - - - - - - - - - - - -
    //
    //      CONSTRUCTORS
    //
    // - - - - - - - - - - - - - - -

    // default constructor
    public ManualMachine(){

    }

    // constructor with MachineResource shared members ( machine_description , killowats per hour )
    // ManualMachine member ( setup_time )
    public ManualMachine(String description , float kwh , float setup_time){
        super(description , kwh); // call the parent constructor to initialize shared members
        this.setup_time = setup_time;
    }


    // - - - - - - - - - - - - - - -
    //
    //      GET FUNCTIONS
    //
    // - - - - - - - - - - - - - - -

    public String toString(){
        String info = super.toString() +
                "    Setup Time : "+setup_time+"\n";
        return info;
    }

    public float getSetupTime(){
        return setup_time;
    }

}
