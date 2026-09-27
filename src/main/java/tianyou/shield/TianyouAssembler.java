package tianyou.shield;

import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.units.UnitFactory;

public class TianyouAssembler extends UnitFactory {

    public TianyouAssembler(String name) {
        super(name);

        this.size = 3;
        this.health = 600;
        this.category = Category.units;

        this.requirements(Category.units, ItemStack.with(
            Items.silicon, 100,
            Items.thorium, 80
        ));

        // Test with vanilla unit instead of Tianyou
        this.plans.add(new UnitFactory.UnitPlan(
            UnitTypes.dagger,
            60f * 10f,
            ItemStack.with(
                Items.silicon, 50,
                Items.thorium, 30
            )
        ));
    }
}
