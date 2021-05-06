package com.vdata.sagittarius.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Contract extends IEntity implements Serializable {

    private static final Logger LOGGER = LogManager.getLogger("com.vdata.sagittarius.Demo");

    private LocalDate acceptDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private Client client;
    private List<InsuredPerson> personList;

    private static final String CSV_SEPARATOR = ";";


    public Contract(LocalDate accDate, LocalDate start, LocalDate end, Client customer, List<InsuredPerson> persons) {

        acceptDate=accDate;
        startDate=start;
        endDate=end;
        client=customer;
        personList=persons;

    }


    public Contract() {
        personList=new ArrayList<>();
    }

    public void addPerson(InsuredPerson e) {
        personList.add(e);
        e.setContract(this);
        System.out.println("Adding Person: " + e.toString());
    }

    @Override
    public String toString() {

        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String border = "\n----------------------------------------------------\n";
        return border + "ContractID:\t" + this.getId() + "\nAcceptDate:\t" + this.getAcceptDate().format(form) +
                "\nStartDate:\t" + this.getStartDate().format(form) + "\nEndDate:\t" + this.getEndDate().format(form)
                + "\nClient:\t" + this.getClient().toString() + "\nPersonList:" + this.getPersonList();
    }

    /**
     * Method that counts and prints the total cost of insurance by the Contract (as the sum of all insured persons)
     * enumerates the collection and summarizes all the individual values of the insured persons
     * Implements foreach cycle
     */
    public double getTotalCost() {

        LOGGER.info("сюди додати різні види обходу списку: /n");

        //1)
        double result = getTotalCost1();
        LOGGER.info("total cost 1 = " + result + "/n");

        //2)
        result = getTotalCost2();
        LOGGER.info("total cost 2 = " + result + "/n");

        //3)
        result = getTotalCost3();
        LOGGER.info("total cost 3 = " + result + "/n");

        //4)
        result = getTotalCost4();
        LOGGER.info("total cost 4 = " + result + "/n");

        return result;
    }

    public double getTotalCost1(){
        double result = 0;
        LOGGER.info("Persons: "  + '\n');
        for (int i=0; i<this.getPersonList().size(); i++) {
            result += getPersonList().get(i).getPersonalCost();
            LOGGER.info(getPersonList().get(i).getClient().toString());
        }
        LOGGER.info("Result = " + result + '\n');
        return result;
    }

    public double getTotalCost2(){
        double result = 0;
        LOGGER.info("Persons:");
        for (InsuredPerson p : this.getPersonList()) {
            result += p.getPersonalCost();
            LOGGER.info(p.getClient().toString());
        }
        LOGGER.info("Result = " + result);
        return result;
    }

    public double getTotalCost3(){
        double result = 0;
        LOGGER.info("Persons:");
        int size = this.getPersonList().size()-1;
        while(size>=0){
            result += getPersonList().get(size).getPersonalCost();
            LOGGER.info(getPersonList().get(size).getClient().toString());
            size--;
        }
        LOGGER.info("Result = " + result);
        return result;
    }

    public double getTotalCost4(){
        double result = 0;
        LOGGER.info("Persons: ");
        int i=0;
        do{
            result += getPersonList().get(i).getPersonalCost();
            LOGGER.info(getPersonList().get(i).getClient().toString());
            i++;
        }while (i!=getPersonList().size());
        LOGGER.info("Result = " + result);
        return result;
    }

    public double getTotalCost5(){
        double result = 0;
        LOGGER.info("Persons: ");
        Iterator iterator = getPersonList().iterator();
        while(iterator.hasNext()){
            InsuredPerson ip = (InsuredPerson)iterator.next();
            result += ip.getPersonalCost();
            LOGGER.info(ip.getClient().toString());
        }
        LOGGER.info("Result = " + result);
        return result;
    }

    public double getTotalCost6(){
        double result = 0;
        LOGGER.info("Persons: ");
        int i=0;
        Iterator iterator1 = getPersonList().iterator();
        while(iterator1.hasNext()){

            result += getPersonList().get(i).getPersonalCost();
            iterator1.next();
            i++;
        }

        Iterator iterator2 = getPersonList().iterator();
        iterator2.forEachRemaining((insuredPerson) ->{
            LOGGER.info(((InsuredPerson)insuredPerson).getClient().toString());
            });
        LOGGER.info("Result = " + result);
        return result;
    }

    public double getTotalCost7(){
        final double[] result = {0};
        LOGGER.info("Persons: ");

        getPersonList().forEach(person -> {
            result[0] += person.getPersonalCost();
            LOGGER.info(person.getClient().toString());
        });
        LOGGER.info("Result = " + result[0]);
        return result[0];
    }

    public double getTotalCost8(){
         double result = 0;
        LOGGER.info("Persons: ");



        Object[] arr = getPersonList().toArray();
        for(int i=0; i< arr.length; i++){
            result +=  ((InsuredPerson)arr[i]).getPersonalCost();
//            LOGGER.info(Arrays.toString(arr));
            LOGGER.info(arr[i].toString());
        }
        LOGGER.info("Result = " + result);
        return result;
    }

    /**
     * internal object Comparator, used for correct work of method "sortPersonsByName" that sort list of Insured Persons
     * by alphabet
     */
    private static final Comparator FIO_COMPARATOR = new Comparator() {
        /** Override method for sorting that compare FIO Strings
         * @param o1 InsuredPerson one
         * @param o2 InsuredPerson two
         * @return int difference between Strings FIO
         */
        @Override
        public int compare(Object o1, Object o2) {
            InsuredPerson person1 = (InsuredPerson) o1;
            InsuredPerson person2 = (InsuredPerson) o2;

            return person1.getClient().getSurname().compareTo(person2.getClient().getSurname());
        }
    };


    /**
     * Method for sorting Insured Persons by dates of their birthday and watching in console
     * For correct comparison class InsuredPerson implements method compareTo
     *
     * @param persons ArrayList with type of objects - InsuredPerson
     * @return sorted ArrayList with type - InsuredPerson
     */
    public List<InsuredPerson> sortPersonsByDate(List<InsuredPerson> persons) {

        persons.sort( (s1,s2) -> (s1.getClient().getBirthday().compareTo( s2.getClient().getBirthday() ) ) );

        return persons;

    }

    /**
     * Method for sorting Insured Persons by FIO`s by alphabet and watching in console
     * For correct comparison class Contract has comparator with override method compare
     *
     * @param persons ArrayList with type of objects - InsuredPerson
     * @return sorted ArrayList with type - InsuredPerson
     */
    public List<InsuredPerson> sortPersonsByName(List<InsuredPerson> persons) {

        LOGGER.info("Persons: " + persons + "/n");
        LOGGER.info("sortPersonsByName: ");
        persons.sort(FIO_COMPARATOR);
        LOGGER.info(persons.toArray()+"/n");
        return persons;

    }

    /**
     * Method for searching Insured Person in ArrayList of persons by it`s unique id
     * use ListIterator to go through all elements
     *
     * @param i int id for search
     * @return InsuredPerson with expected id
     */
    public InsuredPerson getPersonById(int i) {
        InsuredPerson o = new InsuredPerson();

        for (InsuredPerson element : getPersonList()) {
            if (element.getId() == i) {
                return element;
            }
        }
        return o;
    }


    /**
     * Method save the object Contract and all it`s fields: id, dates, Client, PersonList
     * object OutputStreamWriter serialize object Contract into one string with line separators
     */
    public void saveCSV() {

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(".\\src\\Contract"+this.getId()+".csv"), "UTF-8"));) {

            bw.write("id;acceptDate;startDate;endDate;client;personList");
            bw.newLine();
            StringBuilder one = new StringBuilder();
            one.append(this.getId()).append(CSV_SEPARATOR).append(
                    this.getAcceptDate()).append(CSV_SEPARATOR).append(
                    this.getStartDate()).append(CSV_SEPARATOR).append(
                    this.getEndDate()).append(CSV_SEPARATOR);
            one.append(this.getClient().getPersonType()).append(",");

            if("PHYSICAL".equals(this.getClient().getPersonType().toString())){
                PhysicalClient pc = (PhysicalClient) this.getClient();
                one.append(pc.getFirstName()).append(",");
                one.append(pc.getMidName()).append(",");
                one.append(pc.getSurname()).append(",");
            }else if("JURIDICAL".equals(this.getClient().getPersonType().toString())) {
                JuridicalClient jc = (JuridicalClient) this.getClient();
                one.append(jc.getCompanyName()).append(",");
            }
            one.append(this.getClient().getCity()).append(",");
            one.append(this.getClient().getStreet()).append(",");
            one.append(this.getClient().getId()).append(",");
            one.append(CSV_SEPARATOR);
            bw.write(one.toString());

            for (InsuredPerson ip1 : this.getPersonList()) {
                StringBuilder oneLine = new StringBuilder();
                oneLine.append(ip1.getId());
                oneLine.append(",");
                oneLine.append(ip1.getClient().getFirstName());
                oneLine.append(",");
                oneLine.append(ip1.getClient().getMidName());
                oneLine.append(",");
                oneLine.append(ip1.getClient().getSurname());
                oneLine.append(",");
                oneLine.append(ip1.getClient().getBirthday());
                oneLine.append(",");
                oneLine.append(ip1.getPersonalCost());
                oneLine.append("/");
                bw.write(oneLine.toString());
            }

            bw.write(System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * Method reads our file and split the string like the object with type Contract
     *
     * @return deserialized object with type Contract
     */
    public Contract uploadCSV() {


        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(".\\src\\Contract"+this.getId()+".csv")));) {

            String line = "";

            br.readLine();

            while ((line = (String) br.readLine()) != null) {
                String[] details = line.split(CSV_SEPARATOR);

                if (details.length > 0) {

                    String[] foracc = details[1].split("-");
                    LocalDate acc = LocalDate.of(Integer.parseInt(foracc[0]), Integer.parseInt(foracc[1]), Integer.parseInt(foracc[2]));

                    String[] forstart = details[2].split("-");
                    LocalDate start = LocalDate.of(Integer.parseInt(forstart[0]), Integer.parseInt(forstart[1]), Integer.parseInt(forstart[2]));

                    String[] forend = details[3].split("-");
                    LocalDate end = LocalDate.of(Integer.parseInt(forend[0]), Integer.parseInt(forend[1]), Integer.parseInt(forend[2]));

                    String[] forClient = details[4].split(",");

                    PhysicalClient c = null;
//                    if ("PHYSICAL".equals(forClient[0])) {
//
//                        c = new PhysicalClient(PersonType.PHYSICAL, forClient[1], forClient[2], forClient[3], forClient[4], forClient[5], forClient[6], Integer.parseInt(forClient[7]));
//
//                    }else if (forClient[0].equals("JURIDICAL")) {
//                        c = new JuridicalClient(PersonType.JURIDICAL, forClient[1], forClient[2], forClient[3], forClient[4], Integer.parseInt(forClient[7]));
//                    }
                    String[] listP = details[5].split("/");
                    ArrayList<InsuredPerson> resList = new ArrayList<>();

                    for (String s : listP) {
                        String[] concr = s.split(",");
                        String[] date = concr[4].split("-");
                        LocalDate d = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
                        double cost = Double.parseDouble(concr[5]);
                        InsuredPerson insuredPerson = new InsuredPerson();
                        int idPerson = Integer.parseInt(concr[0]);
                        insuredPerson.setId(idPerson);
                        insuredPerson.setPersonalCost(cost);
                        resList.add(insuredPerson);
                    }

                    Contract res = new Contract();

                    int identifier= Integer.parseInt(details[0]);
                    res.setId(identifier);
                    res.setAcceptDate(acc);
                    res.setStartDate(start);
                    res.setEndDate(end);
                    res.setClient(c);
                    res.setPersonList(resList);

                    return res;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Contract();
    }


    public LocalDate setDateAsString(String date) {

        String[]str=date.split("-");
        LocalDate localDate=LocalDate.of(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]));
        return localDate;
    }

    public LocalDate getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(LocalDate acceptDate) {
        this.acceptDate = acceptDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<InsuredPerson> getPersonList() {
        return personList;
    }

    public void setPersonList(List<InsuredPerson> personList) {
        this.personList = personList;
    }
}
