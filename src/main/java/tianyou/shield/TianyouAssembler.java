package tianyou.shield;

import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.PayloadStack;
import mindustry.world.blocks.units.UnitAssembler;

public class TianyouAssembler extends UnitAssembler {

    public TianyouAssembler(String name) {
        super(name);

        this.size = 5;
        this.health = 3600;
        this.buildTime = 60f * 46.75f;
        this.category = Category.units;

        this.requirements(Category.units, ItemStack.with(
            Items.silicon, 600,
            Items.oxide, 1000,
            Items.thorium, 550,
            Items.carbide, 200,
            Items.phaseFabric, 200
        ));

        this.consumePower(180f / 60f);

        this.plans.add(new AssemblerUnitPlan(
            TianyouUnit.tianyou,
            60f * 300f,
            Seq.with(
                new PayloadStack(UnitTypes.merui, 6),
                new PayloadStack(UnitTypes.cleroi, 8),
                new PayloadStack(Blocks.reinforcedSurgeWallLarge, 16),
                new PayloadStack(Blocks.carbideWallLarge, 10)
            )
        ));
    }
}
