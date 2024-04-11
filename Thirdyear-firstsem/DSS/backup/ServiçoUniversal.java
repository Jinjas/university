public class ServiçoUniversal extends Serviço {
    public ServiçoUniversal(long tempoEsperado, String nome, Boolean estado, int tipoServiço, int id) {
        super(tempoEsperado, nome, estado, tipoServiço);
    }

    public ServiçoUniversal() {
        super(3000,"Universal",false,1);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ServiçoUniversal{}";
    }
}
