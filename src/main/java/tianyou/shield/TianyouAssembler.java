package tianyou.shield;

import arc.util.Vars;
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
        this.itemCapacity = 30;
        this.category = Category.units;
        this.buildTime = 60f * 5f;

        this.requirements(Category.units, ItemStack.with(
            Items.silicon, 100,
            Items.thorium, 80
        ));

        this.consumePower(60f / 60f);

        ItemStack[] requirements = ItemStack.with(
            Items.silicon, 50,
            Items.thorium, 30
        );

        this.plans.add(new UnitFactory.UnitPlan(
            UnitTypes.dagger,
            60f * 10f,
            requirements
        ));

        // Set capacities for each required item
        this.capacities = new int[Vars.content.items().size];
        for (ItemStack stack : requirements) {
            this.capacities[stack.item.id] = Math.max(this.capacities[stack.item.id], stack.amount * 2);
        }
    }
}
