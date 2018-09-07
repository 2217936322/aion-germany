/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 *  Aion-Lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Aion-Lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details. *
 *  You should have received a copy of the GNU General Public License
 *  along with Aion-Lightning.
 *  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionemu.gameserver.network.aion.serverpackets;

import com.aionemu.gameserver.network.aion.AionConnection;
import com.aionemu.gameserver.network.aion.AionServerPacket;

/**
 * @author -Nemesiss-
 */
public class SM_L2AUTH_LOGIN_CHECK extends AionServerPacket {

	/**
	 * True if client is authed.
	 */
	private final boolean ok;
	private final String accountName;
	private static byte[] data;

	static {
        data = hex2Byte("000000000000000101010202020303030404040505050606060707070808080909090A0A0A0B0B0B0C0C0C0D0"
        + "D0D0E0E0E0F0F0F1010101111111212121313130000000000000000000000000000000000000000000000000000000000000"
        + "000001F1F1F2020202121212222222323232424242525252626262727272828282929292A2A2A2B2B2B2C2C2C2D2D2D2E2E2"
        + "E2F2F2F3030303131313232323333333434343535353636363737373838383939393A3A3A3B3B3B3C3C3C3D3D3D3E3E3E3F3"
        + "F3F0000000000000000000000000000000000004614144715154816164917174A18184B19194C1A1A4D1B1B4E1C1C4F1D1D5"
        + "01E1E00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000101010"
        + "202020303030404040505050606060707070808080909090A0A0A0B0B0B0C0C0C0D0D0D0E0E0E0F0F0F10101011111112121"
        + "21313134614144715154816164917174A18184B19194C1A1A4D1B1B4E1C1C4F1D1D501E1E1F1F1F202020212121222222232"
        + "3232424242525252626262727272828282929292A2A2A2B2B2B2C2C2C2D2D2D2E2E2E2F2F2F3030303131313232323333333"
        + "434343535353636363737373838383939393A3A3A3B3B3B3C3C3C3D3D3D3E3E3E3F3F3F700010ABD71701001062580801008"
        + "04628070100D0EA1E0D0100402D860C01001004C1070100F0888F060100103527070100205C2707010010161D0D0500408B1"
        + "D0D030070001E0D010080271E0D0100904E1E0D0A0010B9FE1E010090E4512A01009011832B0100107BEA2A0100104EB9290"
        + "100A0570512000000411513000080AA7C120000304513130000406C13130000B0AE7A120000C0D57A12000010CAE11100001"
        + "0F712130000201E13130000E0F21413000090607A120000A0877A120000400E7C120000C0E1FB110000D008FC110000608DE"
        + "21100009002E311000080DBE2110000E0C5E3110000E0DCF41100002079F5110000C077E3110000C08EF4110000002BF5110"
        + "000D09EE3110000D0B5F41100001052F51100005066E211000070B4E21100004021E7110000D080E811000080F2F31100001"
        + "03BE41100007025E5110000602C0712000060BB04120000807A07120000802EEA110000A0561413000080270012000010681"
        + "5130000B07D14130000F0191513000050D0FA1100003089E4110000B049F911000090A107120000B07E051200001886FA110"
        + "000008AFA1100009030051200009073E511000030B706120000004206120000500507120000C034031200007053071200003"
        + "0A0F5110000D0FC7A12000010997B1200003082FA11000040A9FA11000040B0E4110000A093FB110000B0D8F611000080D4F"
        + "811000070E113130000C0FFF6110000F0E5F91100000014E4110000306BE91100004092E9110000C0A505120000E0F305120"
        + "000106906120000D0CC05120000F01A0612000020900612000040DE06120000C0E8E5110000909E8E060100A0C58E0601004"
        + "053C6230100907F840C0500C0F4840C0300D01B850C0100F069850C01000091850C0A009022661E01006044A835010040E2C"
        + "3230100106DC3230100");
	}

	/**
	 * Constructs new <tt>SM_L2AUTH_LOGIN_CHECK </tt> packet
	 *
	 * @param ok
	 */
	public SM_L2AUTH_LOGIN_CHECK(boolean ok, String accountName) {
		this.ok = ok;
		this.accountName = accountName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeImpl(AionConnection con) {
		writeD(ok ? 0x00 : 0x01);
		writeB(data);
		// writeH(171);
		writeS(accountName);
	}

	private static byte[] hex2Byte(String str) {
		byte[] bytes = new byte[str.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(str.substring(2 * i, 2 * i + 2), 16);
		}
		return bytes;
	}
}
