package darktech.core.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelRelay - Either Mojang or a mod author
 * Created using Tabula 4.0.2
 */
public class ModelRelay extends ModelBase {
    public ModelRenderer cube;

    public ModelRelay() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.cube = new ModelRenderer(this, 0, 0);
        this.cube.setRotationPoint(-2.5F, 0.0F, 0.5F);
        this.cube.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4);
        this.setRotateAngle(cube, -1.5707963267948966F, -0.7853981633974483F, -0.7853981633974483F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.cube.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
