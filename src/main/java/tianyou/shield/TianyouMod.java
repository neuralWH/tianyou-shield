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

    public static TianyouAssembler tianyouAssembler;

    public TianyouMod() {
    }

    @Override
    public void loadContent() {
        TianyouBullets.load();
        TianyouUnit.load();
        tianyouAssembler = new TianyouAssembler("tianyou-assembler");
    }

    @Override
    public void init() {
        ShieldSystem.init();
        InterceptSystem.init();

        // Add Advanced Mech Assembler under vanilla Mech Assembler
        TechTree.TechNode assemblerParent = Blocks.mechAssembler.techNode;
        if (assemblerParent != null) {
            new TechTree.TechNode(assemblerParent, tianyouAssembler, new ItemStack[0]);
        }

        // Add Tianyou unit under Advanced Mech Assembler
        TechTree.TechNode unitParent = tianyouAssembler.techNode;
        if (unitParent != null) {
            new TechTree.TechNode(unitParent, TianyouUnit.tianyou, new ItemStack[0]);
        }
    }
}
