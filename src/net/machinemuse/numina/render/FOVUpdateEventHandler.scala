package net.machinemuse.numina.render

import net.minecraftforge.event.ForgeSubscribe
import net.minecraftforge.client.event.FOVUpdateEvent
import net.minecraft.entity.ai.attributes.AttributeInstance
import net.minecraft.entity.SharedMonsterAttributes
import net.machinemuse.numina.basemod.NuminaConfig
import net.minecraftforge.common.Configuration

/**
 * Author: MachineMuse (Claire Semple)
 * Created: 10:07 PM, 10/17/13
 */
object FOVUpdateEventHandler {
  @ForgeSubscribe def onFOVUpdate(e: FOVUpdateEvent) {
    if (NuminaConfig.useFOVFix) {
      val attributeinstance: AttributeInstance = e.entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
      e.newfov = e.fov / ((attributeinstance.getAttributeValue / e.entity.capabilities.getWalkSpeed + 1.0) / 2.0).toFloat
    }
  }

}
