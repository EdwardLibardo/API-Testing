package academyapi.pojos;

/**
 * Pojo One
 * Deserialize data from Endpoint X
 *
 * @author Brayhan.Criollo
 */
public class PojoMockApi {
    private int id;
    private String name;
    private String lastName;
    private int accountNumber;
    private int amount;
    private String transactionType;
    private String email;
    private boolean active;
    private String country;
    private int telephone;


    public PojoMockApi(int id, String name, String lastName, int accountNumber, int amount, String transactionType,
                       String email, boolean active, String country, int telephone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.email = email;
        this.active = active;
        this.country = country;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}