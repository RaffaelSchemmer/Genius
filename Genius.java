import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class Genius extends MIDlet implements CommandListener
{
       private Display display = null;
	   private Command okcommand_jogar;
	   private Command exitcommand_jogar;
	   private Form form_inicio_jogo;
	   private ChoiceGroup lista_opcoes;
	   private String[] string;
	   public void formulario_Inicio_Jogo() /* Responsavel por implementar o login do usuario -- Ok */
	   {
		      display = Display.getDisplay(this);
		      form_inicio_jogo = new Form("                               Genius");
		      okcommand_jogar  = new Command("Jogar",Command.SCREEN,0);
		      exitcommand_jogar = new Command("Sair Jogo",Command.EXIT,0);
		      string = new String[] {"Facil","Medio","Dificil"};
		      lista_opcoes = new ChoiceGroup("Dificuldade :",ChoiceGroup.EXCLUSIVE,string,null);
		      form_inicio_jogo.addCommand(okcommand_jogar);
		      form_inicio_jogo.addCommand(exitcommand_jogar);
		      form_inicio_jogo.append(lista_opcoes);
		      form_inicio_jogo.setCommandListener(this);
		      display.setCurrent(form_inicio_jogo);
	   }
	   public void commandAction(Command c, Displayable d) /* Responsavel por tratar das chamadas dos Command -- Ok */
	   {
	    	if(c == okcommand_jogar)
		    {
		    	ClasseMeuCanvas canvas = new ClasseMeuCanvas(this,lista_opcoes.getSelectedIndex());
		     	display.setCurrent(canvas);
		    }
		    if(c == exitcommand_jogar)
		    {
		     	destroyApp(true);
		    }
	    }
	    public void startApp()
	    {
	       	  formulario_Inicio_Jogo();
	    }
	    public void pauseApp()
	    {

	    }
	    public void destroyApp(boolean unconditional)
	    {
	      	  notifyDestroyed();
	    }
}
