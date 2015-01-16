package darktech.core.client.render;

import java.nio.FloatBuffer;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class VoidCrucibleRenderer extends TileEntitySpecialRenderer implements IItemRenderer {

	VoidCrucibleModel model = new VoidCrucibleModel();
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) { 
		
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		renderTileEntityAt(null, 0,0,0,0);
		
	}

	public static ResourceLocation texture = new ResourceLocation("darktech:textures/blocks/portal_frame.png");
	
	  private static final ResourceLocation field_147529_c = new ResourceLocation("textures/environment/end_sky.png");
	    private static final ResourceLocation field_147526_d = new ResourceLocation("textures/entity/end_portal.png");
	    private static final Random field_147527_e = new Random(31100L);
	    FloatBuffer floatBuffer = GLAllocation.createDirectFloatBuffer(16);
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float p_147500_8_) {

		render(x,y,z);
		
		TileEntityRendererDispatcher t = TileEntityRendererDispatcher.instance;
		
        float f1 = (float)t.field_147560_j;
        float f2 = (float)t.field_147561_k;
        float f3 = (float)t.field_147558_l;
        GL11.glDisable(GL11.GL_LIGHTING);
        field_147527_e.setSeed(31100L);
        float f4 = 1F;

        for (int i = 0; i < 16; ++i)
        {
            GL11.glPushMatrix();
            float f5 = (float)(16 - i);
            float f6 = 0.0625F;
            float f7 = 1.0F / (f5 + 1.0F);

            if (i == 0)
            {
            	Minecraft.getMinecraft().renderEngine.bindTexture(field_147529_c);
                f7 = 0.1F;
                f5 = 65.0F;
                f6 = 0.125F;
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            }

            if (i == 1)
            {
            	Minecraft.getMinecraft().renderEngine.bindTexture(field_147526_d);
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
                f6 = 0.5F;
            }

            float f8 = (float)(-(y + (double)f4));
            float f9 = f8 + ActiveRenderInfo.objectY;
            float f10 = f8 + f5 + ActiveRenderInfo.objectY;
            float f11 = f9 / f10;
            f11 += (float)(y + (double)f4);
            GL11.glTranslatef(f1, f11, f3);
            GL11.glTexGeni(GL11.GL_S, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_OBJECT_LINEAR);
            GL11.glTexGeni(GL11.GL_T, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_OBJECT_LINEAR);
            GL11.glTexGeni(GL11.GL_R, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_OBJECT_LINEAR);
            GL11.glTexGeni(GL11.GL_Q, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_EYE_LINEAR);
            GL11.glTexGen(GL11.GL_S, GL11.GL_OBJECT_PLANE, this.calcFloatBuffer(1.0F, 0.0F, 0.0F, 0.0F));
            GL11.glTexGen(GL11.GL_T, GL11.GL_OBJECT_PLANE, this.calcFloatBuffer(0.0F, 0.0F, 1.0F, 0.0F));
            GL11.glTexGen(GL11.GL_R, GL11.GL_OBJECT_PLANE, this.calcFloatBuffer(0.0F, 0.0F, 0.0F, 1.0F));
            GL11.glTexGen(GL11.GL_Q, GL11.GL_EYE_PLANE, this.calcFloatBuffer(0.0F, 1.0F, 0.0F, 0.0F));
            GL11.glEnable(GL11.GL_TEXTURE_GEN_S);
            GL11.glEnable(GL11.GL_TEXTURE_GEN_T);
            GL11.glEnable(GL11.GL_TEXTURE_GEN_R);
            GL11.glEnable(GL11.GL_TEXTURE_GEN_Q);
            GL11.glPopMatrix();
            GL11.glMatrixMode(GL11.GL_TEXTURE);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, (float)(Minecraft.getSystemTime() % 700000L) / 700000.0F, 0.0F);
            GL11.glScalef(f6, f6, f6);
            GL11.glTranslatef(0.5F, 0.5F, 0.0F);
            GL11.glRotatef((float)(i * i * 4321 + i * 9) * 2.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-0.5F, -0.5F, 0.0F);
            GL11.glTranslatef(-f1, -f3, -f2);
            f9 = f8 + ActiveRenderInfo.objectY;
            GL11.glTranslatef(ActiveRenderInfo.objectX * f5 / f9, ActiveRenderInfo.objectZ * f5 / f9, -f2);

            GL11.glScaled(1, 1, 1);
            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawingQuads();
            f11 = field_147527_e.nextFloat() * 0.5F + 0.1F;
            float f12 = field_147527_e.nextFloat() * 0.5F + 0.4F;
            float f13 = field_147527_e.nextFloat() * 0.5F + 0.5F;

            if (i == 0)
            {
                f13 = 1.0F;
                f12 = 1.0F;
                f11 = 1.0F;
            }

            double y2 = 0.1;
            
            tessellator.setColorRGBA_F(f11 * f7, f12 * f7, f13 * f7, 1.0F);
            tessellator.addVertex(x, y + y2, z);
            tessellator.addVertex(x, y + y2, z  + (double)f4);
            tessellator.addVertex(x  + (double)f4, y + y2, z + (double)f4);
            tessellator.addVertex(x  + (double)f4, y + y2, z);
            tessellator.draw();
            GL11.glPopMatrix();
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
        }

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_GEN_S);
        GL11.glDisable(GL11.GL_TEXTURE_GEN_T);
        GL11.glDisable(GL11.GL_TEXTURE_GEN_R);
        GL11.glDisable(GL11.GL_TEXTURE_GEN_Q);
        GL11.glEnable(GL11.GL_LIGHTING);
	}
	
	public void render(double x, double y, double z)
	{
		GL11.glPushMatrix();
		
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glTranslated(x + 0.5 , y + 0.5D, z  + 0.5);
		GL11.glScaled(0.1, 0.1, 0.1);
		OpenGlHelper.setLightmapTextureCoords(0, 0, 0);
		model.render();
		
		GL11.glPopMatrix();
	}

	private FloatBuffer calcFloatBuffer(float p_147525_1_, float p_147525_2_, float p_147525_3_, float p_147525_4_)
    {
        this.floatBuffer.clear();
        this.floatBuffer.put(p_147525_1_).put(p_147525_2_).put(p_147525_3_).put(p_147525_4_);
        this.floatBuffer.flip();
        return this.floatBuffer;
    }

}
