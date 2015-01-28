package darktech.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class VoidCrucibleRecipe {

	ItemStack input;
	ItemStack output;
	int multiplier;

	public VoidCrucibleRecipe(int multiplier, Object in, ItemStack output) {
			if (in instanceof Block)
				input = new ItemStack(Item.getItemFromBlock((Block) in));
			else if (in instanceof Item)
				input = new ItemStack((Item) in);
			else if (in instanceof ItemStack)
				input = (ItemStack) in;
		this.output = output;
		this.multiplier = multiplier;
	}

	public boolean doesStackMatchInput(ItemStack stack) {
		return input.getItem() != null && stack.getItem() != null
				&& input.isItemEqual(stack);
	}

	public ItemStack getOutput() {
		return output;
	}

	public int getMultiplier() {
		return multiplier;
	}
}
