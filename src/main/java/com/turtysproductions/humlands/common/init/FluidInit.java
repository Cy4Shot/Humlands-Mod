public class FluidInit
{
	public static final FluidFlux FLUIDFLUX_FLOWING_FLUX = null;
	public static final FluidFlux FLUIDFLUX_FLUX = null;
	
	public static class Tags {
		public static final Tag<Fluid> FLUX = new FluidTags.Wrapper(new ResourceLocation(HumlandsMod.MOD_ID, "flux_tag"));
	}
	 
	 public static final String MODID = "humlands";

	    public static final ResourceLocation FLUX_STILL = new ResourceLocation("humlands:blocks/flux_still");
	    public static final ResourceLocation FLUX_FLOWING = new ResourceLocation("humlands:blocks/flux_flowing");

	    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MODID);
	    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MODID);
	    public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, MODID);

	    public static RegistryObject<FlowingFluid> flux_fluid = FLUIDS.register("flux_fluid", () -> new ForgeFlowingFluid.Source(FluidInit.flux_fluid_properties));
	    public static RegistryObject<FlowingFluid> flux_flowing = FLUIDS.register("flux_flowing", () -> new ForgeFlowingFluid.Flowing(FluidInit.flux_fluid_properties));

	    public static RegistryObject<FlowingFluidBlock> flux_block = BLOCKS.register("flux_block", () -> new FlowingFluidBlock(flux_fluid, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
	    
	   

	    public static final ForgeFlowingFluid.Properties flux_fluid_properties = new ForgeFlowingFluid.Properties(flux_fluid, flux_flowing, FluidAttributes.builder(FLUX_STILL, FLUX_FLOWING)).bucket(ItemInit.full_vial).block(flux_block);

		
		}
