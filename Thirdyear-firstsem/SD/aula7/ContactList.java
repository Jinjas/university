package aula7;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

class ContactList extends ArrayList<Contact> {

    // @TODO
    public void serialize(DataOutputStream out) throws IOException {
        out.writeInt(this.size());
        this.forEach((contact -> {
            try {
                serialize(out);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    // @TODO
    public static ContactList deserialize(DataInputStream in) throws IOException {
            int tamanho = in.readInt();
            ContactList contacts = (ContactList) new ArrayList<Contact>();
            Contact c;
            for(int i = 0; i<tamanho; i++){
                c = Contact.deserialize(in);
                contacts.add(c);
            }
        return null;
    }

}
