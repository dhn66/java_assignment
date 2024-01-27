import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;



public class MainApp{

    // Lists //
    private ArrayList<Resource> resources; // Resources List
    private ArrayList<ProductionOrder> orders; // production orders List
    private ArrayList<ConsumptionMovement> consumptionMovements; // consumption movements List

    Scanner sc;

    public MainApp(){
        // construct Lists
        resources = new ArrayList<>();
        orders = new ArrayList<>();
        consumptionMovements = new ArrayList<>();

        sc = new Scanner(System.in);
    }

    public void Init(){

        // Initialize List with some default values..
        Init_Resources();
        Init_Orders();
        Init_ConsumptionMovements();

    }

    // Initialize Resources
    private void Init_Resources(){
        // create some Human Resources
        Resource human_res1 = new HumanResource("Giwrgos","Papas", "Plumber" , 35.0f);
        Resource human_res2 = new HumanResource("Maria" , "Kwnstantinoy" , "Engineer" , 50.0f);
        Resource human_res3 = new HumanResource("Panagiotis" , "Mitogloy" , "Engine Operator" , 32.0f);
        Resource human_res4 = new HumanResource("Dimitra" , "Marinoy" , "Engine Operator" , 31.99f);
        // add them to Resources List
        resources.add(human_res1);
        resources.add(human_res2);
        resources.add(human_res3);
        resources.add(human_res4);

        // create some Machine ( AutoMachine or ManualMachine ) Resources
        Resource machine_res1 = new AutoMachine("Casting Machine" , 490.235f);
        Resource machine_res2 = new AutoMachine("Press Machine" ,  362.98f);
        Resource machine_res3 = new AutoMachine("Condenser Machine" , 218.301f);

        Resource machine_res4 = new ManualMachine("Can cutter Machine" , 192.195f , 27.0f);
        Resource machine_res5 = new ManualMachine("Can packer Machine" , 120.45f , 15.0f);
        Resource machine_res6 = new ManualMachine("Can stuffing Machine" , 84.120f , 45.0f);

        // add them to Resources List
        resources.add(machine_res1);
        resources.add(machine_res2);
        resources.add(machine_res3);
        resources.add(machine_res4);
        resources.add(machine_res5);
        resources.add(machine_res6);
    }

    // Initialize production orders List
    private void Init_Orders(){
        // create some Production orders
        ProductionOrder order1 = new ProductionOrder("Tuna Can");
        ProductionOrder order2 = new ProductionOrder("Bean Can");
        ProductionOrder order3 = new ProductionOrder("Beef can");

        // add them to ProductionOrders List
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
    }

    // Initialize consumptionMovements List
    private void Init_ConsumptionMovements(){
        Random r = new Random();
        int ordersMax = orders.size()-1;
        int resourcesMax = resources.size() -1;

        // create some Consumption Movements with random orders,resources from the above Lists and random consumption time

        int order_index = r.nextInt(ordersMax + 1);            // generate a random int from [0 , orders.size()-1]
        int resource_index = r.nextInt( resourcesMax + 1);     // generate a random int from [0 , resources.size()-1]
        float random_time = 20.0f + r.nextFloat() * (240.0f - 20.0f); // generate a random float from [20.0f , 240.0f]
        ProductionOrder random_order = orders.get(order_index);       // get the random ProductionOrder
        Resource random_resource = resources.get(resource_index);     // get the random Resource
        ConsumptionMovement mov1 = new ConsumptionMovement( random_order , "14/5/2019" , random_resource , random_time );

        order_index = r.nextInt(ordersMax + 1);
        resource_index = r.nextInt( resourcesMax + 1);
        random_time = 20.0f + r.nextFloat() * (240.0f - 20.0f);
        random_order = orders.get(order_index);
        random_resource = resources.get(resource_index);
        ConsumptionMovement mov2 = new ConsumptionMovement( random_order , "23/5/2019" , random_resource , random_time );

        order_index = r.nextInt(ordersMax + 1);
        resource_index = r.nextInt( resourcesMax + 1);
        random_time = 20.0f + r.nextFloat() * (240.0f - 20.0f);
        random_order = orders.get(order_index);
        random_resource = resources.get(resource_index);
        ConsumptionMovement mov3 = new ConsumptionMovement( random_order , "09/1/2019" , random_resource , random_time );

        order_index = r.nextInt(ordersMax + 1);
        resource_index = r.nextInt( resourcesMax + 1);
        random_time = 20.0f + r.nextFloat() * (240.0f - 20.0f);
        random_order = orders.get(order_index);
        random_resource = resources.get(resource_index);
        ConsumptionMovement mov4 = new ConsumptionMovement( random_order , "09/1/2019" , random_resource , random_time );

        // add them to ConsumptionMovements List
        consumptionMovements.add(mov1);
        consumptionMovements.add(mov2);
        consumptionMovements.add(mov3);
        consumptionMovements.add(mov4);
    }


    private void showProductionOrders(){
        System.out.println("\n - - - - PRODUCTION ORDERS - - - -");

        int i = 1;
        for(ProductionOrder order : orders){
            System.out.println("ProductionOrder["+i+"]");
            System.out.println(order.toString()+"\n");
            i++;
        }
        System.out.println();
    }

    private void showResources(){

        System.out.println("\n - - - - RESOURCES - - - -");

        int i = 1;
        String info="";
        for(Resource res : resources)
        {
            System.out.println("\nResource["+i+"]");
            System.out.println(res.toString() +"\n");
            i++;
        }
        System.out.println();

    }

    private void showConsumptionMovements(){

        showProductionOrders();
        System.out.print("\nchoose ProductionOrder : ");
        int order_index = sc.nextInt();
        order_index = order_index-1;
        if(order_index <0 || order_index >= orders.size()){
            System.out.println("~ Invalid input! Failed to showConsumptionMovements!");
            return;
        }

        int order_id = orders.get(order_index).getId();

        System.out.println("\n - - - - CONSUMPTION_MOVEMENTS - - - -");
        int i = 1;
        for(ConsumptionMovement mov : consumptionMovements){
            if(mov.getProductionOrderId() == order_id){
                System.out.println("ConsumptionMovement["+i+"]");
                System.out.println(mov.toString()+"\n");
            }
            i++;
        }
        System.out.println();
    }

    private void showMainMenu(){
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("    1.Create new Resource");
        System.out.println("    2.Create new Production Order");
        System.out.println("    3.Create new Consumption Movement");
        System.out.println("    4.Print Resources List");
        System.out.println("    5.Print Production Order's consumption movement");
        System.out.println("    6.Calculate Production's Cost");
        System.out.println("    7.Calculate Resource's consumption cost");
        System.out.println("    8.Exit");
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - -\n");

        System.out.print("\nchoice : ");
    }

    public void run(){


        while(true)
        {
            showMainMenu(); // Show main menu
            int choice = sc.nextInt(); // wait for user to choose action


            // take action based on user's choice
            switch (choice)
            {
                case 1: createResource();
                    break;

                case 2: createProductionOrder();
                    break;

                case 3: createConsumptionMovement();
                    break;

                case 4: showResources();
                    break;

                case 5: showConsumptionMovements();
                    break;

                case 6: calculateProductionCost();
                    break;

                case 7: calculateResourceConsumptionCost();
                    break;

                case 8: System.exit(1);
            }

        }
        //


    }

    private void createResource(){
        System.out.println("\n - - - - CREATING RESOURCE - - - -");
        System.out.println("    1.Human Resource");
        System.out.println("    2.AutoMachine Resource");
        System.out.println("    3.ManualMachine Resource");
        System.out.print("\nchoose type : ");
        int type = sc.nextInt();

        Resource resource = null;

        sc.nextLine();
        switch (type) {

            case 1: {
                System.out.println("\n - - - - CREATING HUMAN RESOURCE - - - -");

                System.out.print("Name : ");
                String name = sc.nextLine();

                System.out.print("\nSurname : ");
                String surname = sc.nextLine();

                System.out.print("\nSpeciality : ");
                String speciality = sc.nextLine();

                System.out.print("\nWage : ");
                float wage = sc.nextFloat();

                resource = new HumanResource(name, surname, speciality, wage);
            }
            break;

            case 2: {
                System.out.println("\n - - - - CREATING AutoMACHINE RESOURCE - - - -");

                System.out.print("Description : ");
                String desc = sc.nextLine();

                System.out.print("\nKilloWats per hour : ");
                float kwh = sc.nextFloat();

                resource = new AutoMachine(desc, kwh);
            }
            break;


            case 3:{
                System.out.println("\n - - - - CREATING ManualMACHINE RESOURCE - - - -");

                System.out.print("Description : ");
                String desc = sc.nextLine();

                System.out.print("\nKilloWats per hour : ");
                float kwh = sc.nextFloat();

                System.out.print("\nSetup Time : ");
                float time = sc.nextFloat();

                resource = new ManualMachine(desc, kwh , time);
            }break;
        }

        if(resource != null){
            resources.add(resource);
            System.out.println(resource.toString());
        }
        else
            System.out.println("~ Failed to create Resource.");

    }

    private void createProductionOrder(){
        System.out.println("\n - - - - CREATING PRODUCTION ORDER - - - -");
        sc.nextLine();

        System.out.print("Description : ");
        String desc = sc.nextLine();

        ProductionOrder order = new ProductionOrder(desc);
        orders.add(order);

        System.out.println("- Production Order created successfully!");
        System.out.println(order.toString());
    }

    private void createConsumptionMovement() {
        System.out.println("\n - - - - CREATING CONSUMPTION MOVEMENT - - - -");
       // sc.nextLine();

        // choose ProductionOrder
        showProductionOrders();
        System.out.print("\n choose ProductionOrder : ");
        int order_index = sc.nextInt();
        order_index = order_index - 1;
        if (order_index < 0 || order_index >= orders.size()) {
            System.out.println("~ Invalid choice! Failed to create Consumption Movement.");
            return;
        }

        // choose Resource
        showResources();
        System.out.print("\n choose Resource : ");
        int resource_index = sc.nextInt();
        resource_index = resource_index - 1;
        if (resource_index < 0 || resource_index >= resources.size()) {
            System.out.println("~ Invalid choice! Failed to create Consumption Movement.");
            return;
        }

        sc.nextLine();

        System.out.print("\nDate : ");
        String date = sc.nextLine();

        System.out.print("\nConsumption time : ");
        float time = sc.nextFloat();

        ConsumptionMovement mov = new ConsumptionMovement(orders.get(order_index), date, resources.get(resource_index), time);
        consumptionMovements.add(mov);

        System.out.println("- ConsumptionMovement successfully created!");
        System.out.println(mov.toString());

    }


    private void calculateProductionCost(){
        System.out.println("\n - - - - CALCULATE PRODUCTION COST - - - -");

        showProductionOrders();
        System.out.print("\n choose ProductionOrder : ");
        int order_index = sc.nextInt();
        order_index = order_index-1;

        if(order_index <0 || order_index >= orders.size()){
            System.out.println("~ Invalid input! Failed to calculate ProductionOrder cost");
            return;
        }

        ProductionOrder order = orders.get(order_index);
        int order_id = order.getId();

        float production_cost = 0.0f;
        for(ConsumptionMovement mov : consumptionMovements){
            if(mov.getProductionOrderId() == order_id){
                production_cost += mov.getConsumptionCost();
            }
        }

        System.out.println("- Production Order's["+order_index+"] cost : "+production_cost);
    }

    private void calculateResourceConsumptionCost(){
        System.out.println("\n - - - -  CALCULATE RESOURCE CONSUMPTION COST - - - -");

        showResources();
        System.out.print("\n choose Resource : ");
        int resource_index = sc.nextInt();
        resource_index = resource_index -1;

        if(resource_index <0 || resource_index >= resources.size()){
            System.out.println("~ Invalid input! Failed to calculate Resource's consumption cost!");
            return;
        }

        Resource res = resources.get(resource_index);
        int res_id = res.getId();

        float res_consumption_cost = 0.0f;
        for(ConsumptionMovement mov : consumptionMovements){
            if(mov.getResource().getId() == res_id){
                res_consumption_cost += mov.getConsumptionCost();
            }
        }

        System.out.println("- Resource's["+resource_index+"] Consumption Cost : "+res_consumption_cost);

    }

    public static void main(String[] args){

        MainApp app = new MainApp();
        app.Init();
        app.run();

    }
}
