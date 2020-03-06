public class FilledVialTrigger extends AbstractCriterionTrigger<FilledVialTrigger.Instance> 
{
	private static final ResourceLocation ID = new ResourceLocation("filled_vial_trigger");

	   public ResourceLocation getId() {
	      return ID;
	   }

	   public FilledVialTrigger.Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
	      ItemPredicate itempredicate = ItemPredicate.deserialize(json.get("item"));
	      return new FilledVialTrigger.Instance(itempredicate);
	   }

	   public void trigger(ServerPlayerEntity serverplayer, ItemStack stack) {
	      this.func_227070_a_(serverplayer.getAdvancements(), (serverplayer) -> {
	         return stack.test(stack);
	      });
	   }

	   public static class Instance extends CriterionInstance {
	      private final ItemPredicate item;

	      public Instance(ItemPredicate item) {
	         super(FilledVialTrigger.ID);
	         this.item = item;
	      }

	      public static FilledVialTrigger.Instance forItem(ItemPredicate predicate) {
	         return new FilledVialTrigger.Instance(predicate;
	      }

	      public boolean test(ItemStack stack) {
	         return this.item.test(stack);
	      }

	      public JsonElement serialize() {
	         JsonObject jsonobject = new JsonObject();
	         jsonobject.add("item", this.item.serialize());
	         return jsonobject;
	      }
	   }
}
