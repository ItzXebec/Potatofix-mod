# 🥔 PotatoFix
Developed by ItzXebec

A lightweight Fabric optimization mod that fixes performance issues and rendering bugs 
that other mods don't cover — built specifically for low-end PCs and integrated graphics.

## ⚡ What does it do?
Minecraft has always had performance issues on weak hardware, but versions 1.21.5 and 
above made things significantly worse by introducing rendering changes that hit integrated 
graphics especially hard. Most optimization mods like Sodium and Lithium are great, but 
they leave gaps that PotatoFix fills.

PotatoFix targets the root causes of lag on low-end hardware — redundant GPU state 
changes, particle lag spikes, and frame render inefficiencies that vanilla Minecraft 
doesn't bother optimizing.

## ✨ What it fixes
- Redundant OpenGL state changes that are disproportionately expensive on integrated graphics
- Particle lag spikes caused by explosions, mob deaths and weather effects
- Unnecessary shader state resets every frame
- General rendering inefficiencies on low RAM systems

## 🛠 Installation
1. Make sure you have Fabric Loader installed for your Minecraft version
2. Download the latest PotatoFix jar from the Releases page
3. Drop it into your .minecraft/mods folder
4. Launch and enjoy better performance

> No Fabric API required — just Fabric Loader.

## ✅ Compatibility
Works alongside Sodium, Lithium, Starlight, Debugify and all major optimization mods.
Client-side only — safe on any server. No config needed, works out of the box.

## 📜 License
MIT License. Free to use, modify and distribute with credit to the original author.
