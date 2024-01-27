public class HumanResource extends Resource{

    private String name;
    private String surname;
    private String speciality;
    private float wage;

    // - - - - - - - - - - - - - - -
    //
    //      CONSTRUCTORS
    //
    // - - - - - - - - - - - - - - -

    // default constructor
    public HumanResource(){
        name = "";
        surname = "";
        speciality = "";
        wage = 0.0f;
    }

    // constructor with HumanResource members
    // ( name , surname , speciality , wage )
    public HumanResource(String name , String surname , String speciality , float wage){
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
        this.wage = wage;
    }

    // - - - - - - - - - - - - - - -
    //
    //      GET FUNCTIONS
    //
    // - - - - - - - - - - - - - - -

    public String toString(){
        String info = super.toString() +
                      "    Name : "+name+"\n" +
                      "    Surname : "+surname+"\n"+
                      "    Speciality : "+speciality+"\n"+"" +
                      "    Wage : "+wage+"\n";
        return info;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getSpeciality(){
        return speciality;
    }

    public float getWage(){
        return wage;
    }
}
