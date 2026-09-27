package tianyou.shield;

import mindustry.content.Items;
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

        this.plans.add(new UnitFactory.UnitPlan(
            TianyouUnit.tianyou,
            60f * 10f,
            ItemStack.with(
                Items.silicon, 50,
                Items.thorium, 30
            )
        ));
    }
}
