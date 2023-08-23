package enums;

public class InnerEnums {
    public static void main(String[] args) {
        System.out.println("Perfect Raid:");
        System.out.println("Tanks:");
        for (PerfectRaid.Role tank : PerfectRaid.TANK.values) {
            System.out.println(tank);
        }
        System.out.println("---\nHealers:");
        for (PerfectRaid.Role tank : PerfectRaid.Healer.values) {
            System.out.println(tank);
        }
        System.out.println("---\nDamage Dealers:");
        for (PerfectRaid.Role tank : PerfectRaid.DamageDealer.values) {
            System.out.println(tank);
        }
        System.out.println("======");
    }

    enum PerfectRaid {
        TANK(Role.Tank.class), Healer(Role.Healer.class), DamageDealer(Role.DamageDealer.class);

        Role[] values;
        PerfectRaid(Class<? extends Role>  characters) {
            values = characters.getEnumConstants();
        }

        interface Role {
            enum Tank implements Role {EMEON, EGLIN}
            enum Healer implements Role {ENDEMEON, SAELGAR}
            enum DamageDealer implements Role {LEAN, ZANN}
        }
    }
}
