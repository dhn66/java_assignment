public class Resource{

    static int resources_count = 0;

    private int Id;

    public Resource(){
        Id = resources_count;
        resources_count++;
    }


    public int getId(){
        return Id;
    }

    public String toString(){
        String info =
                "    Type : "+getClass().getName() +"\n"+
                "    Id : "+Id+"\n";
        return info;
    }

    // - - - - - - - - - - - - - - -
    //
    //      HUMAN RESOURCE FUNCTIONS
    //
    // - - - - - - - - - - - - - - -

    public String getName(){
        return "";
    }

    public String getSurname(){
        return "";
    }

    public String getSpeciality(){
        return "";
    }

    public float getWage(){
        return 0.0f;
    }

    // - - - - - - - - - - - - - - -
    //
    //      MACHINE RESOURCE FUNCTIONS
    //
    // - - - - - - - - - - - - - - -

    public float getKwh(){
        return 0.0f;
    }

    public float getSetupTime(){
        return 0.0f;
    }

    public String getDescription(){
        return null;
    }


}
