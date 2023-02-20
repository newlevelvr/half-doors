package amymialee.halfdoors;

import amymialee.halfdoors.blocks.DoorcutterBlock;
import amymialee.halfdoors.blocks.HalfDoorBlock;
import amymialee.halfdoors.recipe.DoorSmithingRecipe;
import amymialee.halfdoors.recipe.DoorcuttingRecipe;
import amymialee.halfdoors.screens.DoorcutterScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("unused")
public class Halfdoors implements ModInitializer {
    public static final String MOD_ID = "halfdoors";
    public static final Random RANDOM = new Random();
    public static final ArrayList<Item> MOD_ITEMS = new ArrayList<>();
    public static final ItemGroup DOOR_GROUP = FabricItemGroupBuilder.create(id("halfdoor_group")).icon(Halfdoors::getRecipeKindIcon).build();

    public static final Block IRON_HALFDOOR = registerBlock("iron_halfdoor", new HalfDoorBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5.0f).sounds(BlockSoundGroup.METAL).nonOpaque()));
    public static final Block OAK_HALFDOOR = registerBlock("oak_halfdoor", new HalfDoorBlock(FabricBlockSettings.of(Material.WOOD, Blocks.OAK_PLANKS.getDefaultMapColor()).strength(3.0f).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block SPRUCE_HALFDOOR = registerBlock("spruce_halfdoor", new HalfDoorBlock(FabricBlockSettings.of(Material.WOOD, Blocks.SPRUCE_PLANKS.getDefaultMapColor()).strength(3.0f).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block BIRCH_HALFDOOR = registerBlock("birch_halfdoor", new HalfDoorBlock(FabricBlockSettings.of(Material.WOOD, Blocks.BIRCH_PLANKS.getDefaultMapColor()).strength(3.0f).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block JUNGLE_HALFDOOR = registerBlock("jungle_halfdoor", new HalfDoorBlock(FabricBlockSettings.of(Material.WOOD, Blocks.JUNGLE_PLANKS.getDefaultMapColor()).strength(3.0f).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block ACACIA_HALFDOOR = registerBlock("acacia_halfdoor", new HalfDoorBlock(FabricBlockSettings.of(Material.WOOD, Blocks.ACACIA_PLANKS.getDefaultMapColor()).strength(3.0f).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block DARK_OAK_HALFDOOR = registerBlock("dark_oak_halfdoor", new HalfDoorBlock(FabricBlockSettings.of(Material.WOOD, Blocks.DARK_OAK_PLANKS.getDefaultMapColor()).strength(3.0f).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block CRIMSON_HALFDOOR = registerBlock("crimson_halfdoor", new HalfDoorBlock(FabricBlockSettings.of(Material.NETHER_WOOD, Blocks.CRIMSON_PLANKS.getDefaultMapColor()).strength(3.0f).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block WARPED_HALFDOOR = registerBlock("warped_halfdoor", new HalfDoorBlock(FabricBlockSettings.of(Material.NETHER_WOOD, Blocks.WARPED_PLANKS.getDefaultMapColor()).strength(3.0f).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block DOORCUTTER = registerBlock("doorcutter", new DoorcutterBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.5f).sounds(BlockSoundGroup.STONE).nonOpaque()));

    public static ScreenHandlerType<DoorcutterScreenHandler> DOOR_CUTTER_SCREEN_HANDLER = Registry.register(Registry.SCREEN_HANDLER, MOD_ID, new ScreenHandlerType<>(DoorcutterScreenHandler::new));
    public static RecipeSerializer<DoorcuttingRecipe> DOOR_CUTTING_RECIPE = RecipeSerializer.register(id("doorcutting").toString(), new DoorcuttingRecipe.OpenSerializer<>(DoorcuttingRecipe::new));
    public static RecipeSerializer<DoorSmithingRecipe> DOOR_SMITHING_RECIPE = RecipeSerializer.register(id("smithing").toString(), new DoorSmithingRecipe.OpenSerializer());
    public static final RecipeType<DoorcuttingRecipe> RECIPE_TYPE = RecipeType.register(Halfdoors.id(Halfdoors.MOD_ID).toString());

    @Override
    public void onInitialize() {
    }

    private static Block registerBlock(String name, Block block) {
        Registry.register(Registry.BLOCK, id(name), block);
        registerItem(name, new BlockItem(block, new FabricItemSettings().group(DOOR_GROUP)));
        return block;
    }

    public static Item registerItem(String name, Item item) {
        Registry.register(Registry.ITEM, id(name), item);
        MOD_ITEMS.add(item);
        return item;
    }

    public static ItemStack getRecipeKindIcon() {
        return MOD_ITEMS.get(RANDOM.nextInt(MOD_ITEMS.size() - 1)).getDefaultStack();
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}