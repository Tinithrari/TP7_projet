package HeugueXavier.TP7;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.lwjgl.Sys;
import org.lwjgl.opengl.*; //cf. javadoc : contient la classe Display
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;
/**
 * Classe gérant l'apparence des cartes
 * @author Tinithrari
 *
 */
public class GCarte {
	private Carte lCarte;
	private int posX;
	private int posY;
	private int posZ;
	private Texture dos,face;
	/**
	 * Permet de construire une apparence à partir de 3 positions
	 * et d'une carte logique
	 * @param lCarte Une carte logique
	 * @param posX La position x
	 * @param posY La position y
	 * @param posZ la position z
	 */
	public GCarte(Carte lCarte, int posX, int posY, int posZ){
		this.lCarte = lCarte;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		dos = loadATexture("dos");
		face = loadATexture(lCarte.getFace().toString()+lCarte.getCouleur().toString());
	}
	/**
	 * Classe permettant de dessiner la carte
	 */
	public void draw(){
		dos.bind();
		glTranslatef( posX+0.25f, posY+0.5f, posZ+0.005f);
		GL11.glBegin(GL11.GL_QUADS);
			glTexCoord2f(1,1);
			glVertex3d(-0.25,-0.5,0.0005);
			glTexCoord2f(0,1);
			glVertex3d(0.25,-0.5,0.0005);
			glTexCoord2f(0,0);
			glVertex3d(0.25,0.5,0.0005);
			glTexCoord2f(1,0);
			glVertex3d(-0.25,0.5,0.0005);
			glColor3ub((byte)255,(byte)255,(byte)255);
		GL11.glEnd();
		face.bind();
		GL11.glBegin(GL11.GL_QUADS);
			glTexCoord2f(1,1);
			glVertex3d(-0.25,-0.5,-0.0005);
			glTexCoord2f(0,1);
			glVertex3d(0.25,-0.5,-0.0005);
			glTexCoord2f(0,0);
			glVertex3d(0.25,0.5,-0.0005);
			glTexCoord2f(1,0);
			glVertex3d(-0.25,0.5,-0.0005);
		GL11.glEnd();
		glDisable(GL_TEXTURE_2D);
		GL11.glBegin(GL11.GL_QUADS);
			glVertex3d(-0.25,0.5,0.0005);
			glVertex3d(-0.25,0.5,-0.0005);
			glVertex3d(-0.25,-0.5, -0.0005);
			glVertex3d(-0.25,-0.5,0.0005);
			
			glVertex3d(0.25,0.5,0.0005);
			glVertex3d(0.25,0.5,-0.0005);
			glVertex3d(0.25,-0.5,-0.0005);
			glVertex3d(0.25,-0.5,0.0005);
			
			glVertex3d(0.25,0.5,0.0005);
			glVertex3d(0.25,0.5,0.0005);
			glVertex3d(-0.25,0.5,-0.0005);
			glVertex3d(-0.25,0.5,0.0005);
			
			glVertex3d(0.25,-0.5,0.0005);
			glVertex3d(0.25,-0.5,-0.0005);
			glVertex3d(-0.25,0.5,-0.0005);
			glVertex3d(-0.25,-0.5,0.0005);
		GL11.glEnd();
	}
	/**
	 * Permet de charger une texture
	 * @param key le nom de l'image à charger (sans extension)
	 * @return la texture chargé.
	 */
	public Texture loadATexture(String key){
		try {
			return TextureLoader.getTexture("PNG", new FileInputStream(new File("res/"+key+".png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
