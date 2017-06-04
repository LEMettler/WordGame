import org.newdawn.slick.Input;

/**
 * Created by Meerlu on 04.06.2017.
 */
public class StringBuilder {
    private String string;
    private Character c;

    public StringBuilder() {

    }

    public String Build(String string, Input input){
        this.string = string;

        if (input.isKeyPressed(Input.KEY_A)){
            string+= "a";
        }else if (input.isKeyPressed(Input.KEY_B)){
            string+= "b";
        }else if (input.isKeyPressed(Input.KEY_C)){
            string+= "c";
        }else if (input.isKeyPressed(Input.KEY_D)){
            string+= "d";
        }else if (input.isKeyPressed(Input.KEY_E)){
            string+= "e";
        }else if (input.isKeyPressed(Input.KEY_F)){
            string+= "f";
        }else if (input.isKeyPressed(Input.KEY_G)){
            string+= "g";
        }else if (input.isKeyPressed(Input.KEY_H)){
            string+= "h";
        }else if (input.isKeyPressed(Input.KEY_I)){
            string+= "i";
        }else if (input.isKeyPressed(Input.KEY_J)){
            string+= "j";
        }else if (input.isKeyPressed(Input.KEY_K)){
            string+= "k";
        }else if (input.isKeyPressed(Input.KEY_L)){
            string+= "l";
        }else if (input.isKeyPressed(Input.KEY_M)){
            string+= "m";
        }else if (input.isKeyPressed(Input.KEY_N)){
            string+= "n";
        }else if (input.isKeyPressed(Input.KEY_O)){
            string+= "o";
        }else if (input.isKeyPressed(Input.KEY_P)){
            string+= "p";
        }else if (input.isKeyPressed(Input.KEY_Q)){
            string+= "q";
        }else if (input.isKeyPressed(Input.KEY_R)){
            string+= "r";
        }else if (input.isKeyPressed(Input.KEY_S)){
            string+= "s";
        }else if (input.isKeyPressed(Input.KEY_T)){
            string+= "t";
        }else if (input.isKeyPressed(Input.KEY_U)){
            string+= "u";
        }else if (input.isKeyPressed(Input.KEY_V)){
            string+= "v";
        }else if (input.isKeyPressed(Input.KEY_W)){
            string+= "w";
        }else if (input.isKeyPressed(Input.KEY_X)){
            string+= "x";
        }else if (input.isKeyPressed(Input.KEY_Y)){
            string+= "y";
        }else if (input.isKeyPressed(Input.KEY_Z)){
            string+= "z";
        }else if (input.isKeyPressed(Input.KEY_BACK)){
            if (!string.equals(""))
                string = string.substring(0, string.length()-1);
        }else if (input.isKeyPressed(Input.KEY_SPACE)){
            string+= " ";
        }

        return string;
    }
}
