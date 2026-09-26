package tianyou.shield;

import mindustry.content.TechTree;
import mindustry.content.UnitTypes;
import mindustry.mod.Mod;
import mindustry.type.ItemStack;

public class TianyouMod extends Mod {

    public TianyouMod() {
    }

    @Override
    public void loadContent() {
        TianyouBullets.load();
        TianyouUnit.load();
        TianyouAssembler.load();
    }

    @Override
    public void init() {
        ShieldSystem.init();
        InterceptSystem.init();

        TechTree.TechNode parent = UnitTypes.collaris.techNode;
        if (parent != null) {
            new TechTree.TechNode(parent, TianyouUnit.tianyou, new ItemStack[0]);
        }
    }
}