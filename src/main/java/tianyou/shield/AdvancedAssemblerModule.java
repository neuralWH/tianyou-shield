package tianyou.shield;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.units.UnitAssemblerModule;

public class AdvancedAssemblerModule extends UnitAssemblerModule {

    public AdvancedAssemblerModule(String name) {
        super(name);

        this.tier = 2;
        this.size = 5;
        this.health = 3100;
        this.buildTime = 30f * 60f;
        this.requirements(Category.units, ItemStack.with(
            Items.thorium, 800,
            Items.phaseFabric, 600,
            Items.oxide, 400,
            Items.carbide, 500
        ));
        this.consumePower(210f / 60f);
    }
}
