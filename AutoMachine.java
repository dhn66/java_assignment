public class AutoMachine extends MachineResource{

    // - - - - - - - - - - - - - - -
    //
    //      CONSTRUCTORS
    //
    // - - - - - - - - - - - - - - -

    // default constructor
    public AutoMachine(){

    }

    // constructor with MachineResource shared members
    // ( machine_description , killowats per hour )
    public AutoMachine(String description , float kwh){
        super(description , kwh); // call the parent constructor to initialize shared members
    }


}
