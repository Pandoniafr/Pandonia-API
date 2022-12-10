package fr.pandonia.tools.raytrace;

import net.minecraft.server.v1_8_R3.AxisAlignedBB;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class BoundingBox {

    //min and max points of hit box
    public Vector max;
    public Vector min;

    public BoundingBox(Vector min, Vector max) {
        this.max = max;
        this.min = min;
    }

    public BoundingBox(Player p, double size) {
        size = Math.abs(size);
        this.max = p.getLocation().add(size, size, size).toVector();
        this.min = p.getLocation().add(-size, -size, -size).toVector();
    }

    //gets min and max point of block
    //  ** 1.8 and earlier **
//    BoundingBox(Block block) {
//        IBlockData blockData = ((CraftWorld) block.getWorld()).getHandle().getType(new BlockPosition(block.getX(), block.getY(), block.getZ()));
//        net.minecraft.server.v1_8_R3.Block blockNative = blockData.getBlock();
//        blockNative.updateShape(((CraftWorld) block.getWorld()).getHandle(), new BlockPosition(block.getX(), block.getY(), block.getZ()));
//        min = new Vector((double) block.getX() + blockNative.B(), (double) block.getY() + blockNative.D(), (double) block.getZ() + blockNative.F());
//        max = new Vector((double) block.getX() + blockNative.C(), (double) block.getY() + blockNative.E(), (double) block.getZ() + blockNative.G());
//    }

    //gets min and max point of block
    //  ** 1.10 **
//    BoundingBox(Block block) {
//        net.minecraft.server.v1_10_R1.BlockPosition bp = new net.minecraft.server.v1_10_R1.BlockPosition(block.getX(), block.getY(), block.getZ());
//        net.minecraft.server.v1_10_R1.WorldServer world = ((org.bukkit.craftbukkit.v1_10_R1.CraftWorld) block.getWorld()).getHandle();
//        net.minecraft.server.v1_10_R1.IBlockData blockData = (net.minecraft.server.v1_10_R1.IBlockData) (world.getType(bp);
//        net.minecraft.server.v1_10_R1.Block blockNative = blockData.getBlock();
//        net.minecraft.server.v1_10_R1.AxisAlignedBB aabb = blockNative.a(blockData, world, bp);
//        min = new Vector(bb.a,bb.b,bb.c);
//        max = new Vector(bb.d,bb.e,bb.f);
//    }

    //gets min and max point of entity
    // only certain nms versions ****
//    BoundingBox(Entity entity){
//        AxisAlignedBB bb = ((CraftEntity) entity).getHandle().getBoundingBox();
//        min = new Vector(bb.a,bb.b,bb.c);
//        max = new Vector(bb.d,bb.e,bb.f);
//    }

    public BoundingBox (AxisAlignedBB bb){
        min = new Vector(bb.a,bb.b,bb.c);
        max = new Vector(bb.d,bb.e,bb.f);
    }

    public Vector midPoint(){
        return max.clone().add(min).multiply(0.5);
    }

}