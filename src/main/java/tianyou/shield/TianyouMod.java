package tianyou.shield;

import mindustry.content.Blocks;
import mindustry.content.TechTree;
import mindustry.content.UnitTypes;
import mindustry.mod.Mod;
import mindustry.type.ItemStack;

public class TianyouMod extends Mod {

    public static TianyouAssembler tianyouAssembler;

    public TianyouMod() {
    }

    @Override
    public void loadContent() {
        tianyouAssembler = new TianyouAssembler("tianyou-assembler");
    }

    @Override
    public void init() {
        TechTree.TechNode parent = Blocks.mechAssembler.techNode;
        if (parent != null) {
            new TechTree.TechNode(parent, tianyouAssembler, new ItemStack[0]);
        }
    }
}
