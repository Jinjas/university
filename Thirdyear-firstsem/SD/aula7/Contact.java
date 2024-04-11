package aula7;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.*;

class Contact {
    private String name;
    private int age;
    private long phoneNumber;
    private String company;     // Pode ser null
    private ArrayList<String> emails;

    public Contact(String name, int age, long phoneNumber, String company, List<String> emails) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.company = company;
        this.emails = new ArrayList<>(emails);
    }

    public String name() { return name; }
    public int age() { return age; }
    public long phoneNumber() { return phoneNumber; }
    public String company() { return company; }
    public List<String> emails() { return new ArrayList(emails); }

    // @TODO
    public void serialize(DataOutputStream out) throws IOException {
        /**
         * int idade        4bytes |    |                               writeInt
         * long phoneNumber 8bytes |        |                           writelong
         * String nome      n+4 bytes |n|        |                      writeUTF
         * String? company  1+size value |b|        | writeBoolean+ write *
         * list <String>    4+n*sizeString |n|      |      |      | writeInt+ n*(writeUTF)
         * */
        out.writeUTF(name());
        out.writeInt(age());
        out.writeLong(phoneNumber());
        out.writeBoolean(company().isEmpty());
        if(!company().isEmpty())
            out.writeUTF(company());
        out.writeInt(emails().size());

        for(String email:emails()){
            out.writeUTF(email);
        }
    }
    // @TODO
    public static Contact deserialize(DataInputStream in) throws IOException {
        String name = in.readUTF();
        int age = in.readInt();
        long phoneNumber = in.readLong();
        boolean companyExists = in.readBoolean();
        String company;
        if (companyExists)
            company = in.readUTF();
        else
            company = null;
        int emailsListSize = in.readInt();
        List <String> emails = new ArrayList<>();
        for (int i = 0 ; i< emailsListSize;i++){
            emails.add(in.readUTF());
        }

        return new Contact(name,age,phoneNumber,company,emails);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name).append(";");
        builder.append(this.age).append(";");
        builder.append(this.phoneNumber).append(";");
        builder.append(this.company).append(";");
        builder.append(this.emails.toString());
        builder.append("}");
        return builder.toString();
    }

}
