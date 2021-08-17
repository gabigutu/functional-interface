public class PersonImpl implements Person {

    @Override
    public String works(String name, String job) {
        return name + " works as a " + job;
    }
}
