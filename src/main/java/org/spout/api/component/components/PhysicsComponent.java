/*
 * This file is part of SpoutAPI.
 *
 * Copyright (c) 2011-2012, SpoutDev <http://www.spout.org/>
 * SpoutAPI is licensed under the SpoutDev License Version 1.
 *
 * SpoutAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * SpoutAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.api.component.components;

import org.spout.api.data.Data;
import org.spout.api.math.Vector3;

/**
 * A component that represents the physics object that is a motion of the entity within the world.
 */
public class PhysicsComponent extends EntityComponent {
	private Vector3 lastVelocity = Vector3.ZERO;

	@Override
	public void onTick(float dt) {
		lastVelocity = getVelocity();
	}

	public Vector3 getVelocity() {
		return getData().get(Data.VELOCITY);
	}

	public void setVelocity(Vector3 velocity) {
		getData().put(Data.VELOCITY, velocity);
	}

	/**
	 * Returns whether the velocity has changed between the last and live velocity values.
	 * @return True if dirty, false if not
	 */
	public boolean isVelocityDirty() {
		return !lastVelocity.equals(getVelocity());
	}
}
