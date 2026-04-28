# 🥔 PotatoFix
Developed by ItzXebec

PotatoFix is a lightweight Fabric optimization mod built for players on low-end 
hardware. While mods like Sodium and Lithium are great, they leave gaps — 
especially on integrated graphics and weak CPUs. PotatoFix fills those gaps.

## ⚡ What it fixes

**💥 Particle lag spikes**
Minecraft has no built-in particle limit. Explosions, mob deaths and weather 
effects can spawn hundreds of particles instantly and tank your FPS. PotatoFix 
caps the particle queue at 2048 to prevent sudden lag spikes.

**💡 Lightmap recalculation**
Minecraft recalculates the lightmap texture every single tick even when lighting 
hasn't changed. PotatoFix caches the last lightmap update and skips unnecessary 
recalculations, reducing CPU overhead every frame.

**👾 Entity render distance**
Minecraft renders all entities regardless of distance. PotatoFix skips rendering 
non-player entities beyond 48 blocks, reducing GPU load in crowded areas.

## ✅ Compatibility
- Works with Sodium, Lithium, Starlight, Debugify and all major optimization mods
- Client-side only — safe on any server
- No config needed — works out of the box
- No Fabric API required
MIT License. Free to use, modify and distribute with credit to the original author.
