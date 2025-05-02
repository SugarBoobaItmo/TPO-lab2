import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

df = pd.read_csv("output.csv").rename(columns=lambda x: x.strip())

df_clean = df.dropna()

plt.figure(figsize=(10, 6))

plt.plot(df_clean["X"], df_clean["Result"], marker='o', linestyle='-', color='b', label="Result")

nan_points = df[df["Result"].isna()]
plt.scatter(nan_points["X"], [0] * len(nan_points), facecolors='none', edgecolors='r', s=100, label="NaN (выколотые)")

plt.xlabel("X")
plt.ylabel("Result")
plt.title("График зависимости Result от X (с выколотыми точками для NaN)")
plt.legend()
plt.grid(True)
plt.show()
