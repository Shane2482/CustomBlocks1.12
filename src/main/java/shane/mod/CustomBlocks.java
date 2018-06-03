package shane.mod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import shane.mod.library.Reference;
import shane.mod.proxy.ServerProxy;




@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class CustomBlocks 
{

@Instance
public static CustomBlocks instance;

@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
public static ServerProxy proxy;


@EventHandler
public void preInit(FMLPreInitializationEvent event) {}

@EventHandler
public void Init(FMLInitializationEvent event) {}

@EventHandler
public void postInit(FMLPostInitializationEvent event) {}
}
