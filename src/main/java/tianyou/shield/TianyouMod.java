package tianyou.shield;

import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.content.TechTree;
import mindustry.content.UnitTypes;
import mindustry.mod.Mod;
import mindustry.type.ItemStack;
import mindustry.type.PayloadStack;
import mindustry.world.blocks.units.UnitAssembler;
import mindustry.world.blocks.units.UnitAssembler.AssemblerUnitPlan;

public class TianyouMod extends Mod {

    public static AdvancedAssemblerModule advancedAssemblerModule;

    public TianyouMod() {
    }

    @Override
    public void loadContent() {
        TianyouBullets.load();
        TianyouUnit.load();
        advancedAssemblerModule = new AdvancedAssemblerModule("advanced-assembler-module");
    }

    @Override
    public void init() {
        ShieldSystem.init();
        InterceptSystem.init();

        // Add Tianyou to Erekir tech tree under Collaris
        TechTree.TechNode parent = UnitTypes.collaris.techNode;
        if (parent != null) {
            new TechTree.TechNode(parent, TianyouUnit.tianyou, new ItemStack[0]);
        }

        // Add Advanced Assembler Module under Basic Assembler Module
        TechTree.TechNode moduleParent = Blocks.basicAssemblerModule.techNode;
        if (moduleParent != null) {
            new TechTree.TechNode(moduleParent, advancedAssemblerModule, new ItemStack[0]);
        }

        // Add production plan to vanilla mech assembler, inserted at index 0 to prioritize
        if (Blocks.mechAssembler instanceof UnitAssembler assembler) {
            AssemblerUnitPlan plan = new AssemblerUnitPlan(
                TianyouUnit.tianyou,
                60f * 300f,
                Seq.with(
                    new PayloadStack(UnitTypes.merui, 6),
                    new PayloadStack(UnitTypes.cleroi, 8),
                    new PayloadStack(Blocks.reinforcedSurgeWallLarge, 16),
                    new PayloadStack(Blocks.carbideWallLarge, 10)
                )
            );
            assembler.plans.insert(0, plan);
        }
    }
}
