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
        this.itemCapacity = 100;
        this.buildTime = 60f * 5f;
        this.category = Category.units;

        this.requirements(Category.units, ItemStack.with(
            Items.silicon, 100,
            Items.thorium, 80
        ));

        this.consumePower(1.5f);

        this.plans.add(new UnitFactory.UnitPlan(
            UnitTypes.dagger,
            60f * 10f,
            ItemStack.with(
                Items.silicon, 50,
                Items.thorium, 30
            )
        ));

        this.capacities = new int[Vars.content.items().size];
        for (ItemStack stack : this.plans.get(0).requirements) {
            this.capacities[stack.item.id] = Math.max(
                this.capacities[stack.item.id],
                stack.amount * 2
            );
        }
    }
}
