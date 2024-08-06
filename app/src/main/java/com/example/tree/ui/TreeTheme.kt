package com.example.compose
import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.tree.ui.theme.backgroundDark
import com.example.tree.ui.theme.backgroundDarkHighContrast
import com.example.tree.ui.theme.backgroundDarkMediumContrast
import com.example.tree.ui.theme.backgroundLight
import com.example.tree.ui.theme.backgroundLightHighContrast
import com.example.tree.ui.theme.backgroundLightMediumContrast
import com.example.tree.ui.theme.errorContainerDark
import com.example.tree.ui.theme.errorContainerDarkHighContrast
import com.example.tree.ui.theme.errorContainerDarkMediumContrast
import com.example.tree.ui.theme.errorContainerLight
import com.example.tree.ui.theme.errorContainerLightHighContrast
import com.example.tree.ui.theme.errorContainerLightMediumContrast
import com.example.tree.ui.theme.errorDark
import com.example.tree.ui.theme.errorDarkHighContrast
import com.example.tree.ui.theme.errorDarkMediumContrast
import com.example.tree.ui.theme.errorLight
import com.example.tree.ui.theme.errorLightHighContrast
import com.example.tree.ui.theme.errorLightMediumContrast
import com.example.tree.ui.theme.inverseOnSurfaceDark
import com.example.tree.ui.theme.inverseOnSurfaceDarkHighContrast
import com.example.tree.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.example.tree.ui.theme.inverseOnSurfaceLight
import com.example.tree.ui.theme.inverseOnSurfaceLightHighContrast
import com.example.tree.ui.theme.inverseOnSurfaceLightMediumContrast
import com.example.tree.ui.theme.inversePrimaryDark
import com.example.tree.ui.theme.inversePrimaryDarkHighContrast
import com.example.tree.ui.theme.inversePrimaryDarkMediumContrast
import com.example.tree.ui.theme.inversePrimaryLight
import com.example.tree.ui.theme.inversePrimaryLightHighContrast
import com.example.tree.ui.theme.inversePrimaryLightMediumContrast
import com.example.tree.ui.theme.inverseSurfaceDark
import com.example.tree.ui.theme.inverseSurfaceDarkHighContrast
import com.example.tree.ui.theme.inverseSurfaceDarkMediumContrast
import com.example.tree.ui.theme.inverseSurfaceLight
import com.example.tree.ui.theme.inverseSurfaceLightHighContrast
import com.example.tree.ui.theme.inverseSurfaceLightMediumContrast
import com.example.tree.ui.theme.onBackgroundDark
import com.example.tree.ui.theme.onBackgroundDarkHighContrast
import com.example.tree.ui.theme.onBackgroundDarkMediumContrast
import com.example.tree.ui.theme.onBackgroundLight
import com.example.tree.ui.theme.onBackgroundLightHighContrast
import com.example.tree.ui.theme.onBackgroundLightMediumContrast
import com.example.tree.ui.theme.onErrorContainerDark
import com.example.tree.ui.theme.onErrorContainerDarkHighContrast
import com.example.tree.ui.theme.onErrorContainerDarkMediumContrast
import com.example.tree.ui.theme.onErrorContainerLight
import com.example.tree.ui.theme.onErrorContainerLightHighContrast
import com.example.tree.ui.theme.onErrorContainerLightMediumContrast
import com.example.tree.ui.theme.onErrorDark
import com.example.tree.ui.theme.onErrorDarkHighContrast
import com.example.tree.ui.theme.onErrorDarkMediumContrast
import com.example.tree.ui.theme.onErrorLight
import com.example.tree.ui.theme.onErrorLightHighContrast
import com.example.tree.ui.theme.onErrorLightMediumContrast
import com.example.tree.ui.theme.onPrimaryContainerDark
import com.example.tree.ui.theme.onPrimaryContainerDarkHighContrast
import com.example.tree.ui.theme.onPrimaryContainerDarkMediumContrast
import com.example.tree.ui.theme.onPrimaryContainerLight
import com.example.tree.ui.theme.onPrimaryContainerLightHighContrast
import com.example.tree.ui.theme.onPrimaryContainerLightMediumContrast
import com.example.tree.ui.theme.onPrimaryDark
import com.example.tree.ui.theme.onPrimaryDarkHighContrast
import com.example.tree.ui.theme.onPrimaryDarkMediumContrast
import com.example.tree.ui.theme.onPrimaryLight
import com.example.tree.ui.theme.onPrimaryLightHighContrast
import com.example.tree.ui.theme.onPrimaryLightMediumContrast
import com.example.tree.ui.theme.onSecondaryContainerDark
import com.example.tree.ui.theme.onSecondaryContainerDarkHighContrast
import com.example.tree.ui.theme.onSecondaryContainerDarkMediumContrast
import com.example.tree.ui.theme.onSecondaryContainerLight
import com.example.tree.ui.theme.onSecondaryContainerLightHighContrast
import com.example.tree.ui.theme.onSecondaryContainerLightMediumContrast
import com.example.tree.ui.theme.onSecondaryDark
import com.example.tree.ui.theme.onSecondaryDarkHighContrast
import com.example.tree.ui.theme.onSecondaryDarkMediumContrast
import com.example.tree.ui.theme.onSecondaryLight
import com.example.tree.ui.theme.onSecondaryLightHighContrast
import com.example.tree.ui.theme.onSecondaryLightMediumContrast
import com.example.tree.ui.theme.onSurfaceDark
import com.example.tree.ui.theme.onSurfaceDarkHighContrast
import com.example.tree.ui.theme.onSurfaceDarkMediumContrast
import com.example.tree.ui.theme.onSurfaceLight
import com.example.tree.ui.theme.onSurfaceLightHighContrast
import com.example.tree.ui.theme.onSurfaceLightMediumContrast
import com.example.tree.ui.theme.onSurfaceVariantDark
import com.example.tree.ui.theme.onSurfaceVariantDarkHighContrast
import com.example.tree.ui.theme.onSurfaceVariantDarkMediumContrast
import com.example.tree.ui.theme.onSurfaceVariantLight
import com.example.tree.ui.theme.onSurfaceVariantLightHighContrast
import com.example.tree.ui.theme.onSurfaceVariantLightMediumContrast
import com.example.tree.ui.theme.onTertiaryContainerDark
import com.example.tree.ui.theme.onTertiaryContainerDarkHighContrast
import com.example.tree.ui.theme.onTertiaryContainerDarkMediumContrast
import com.example.tree.ui.theme.onTertiaryContainerLight
import com.example.tree.ui.theme.onTertiaryContainerLightHighContrast
import com.example.tree.ui.theme.onTertiaryContainerLightMediumContrast
import com.example.tree.ui.theme.onTertiaryDark
import com.example.tree.ui.theme.onTertiaryDarkHighContrast
import com.example.tree.ui.theme.onTertiaryDarkMediumContrast
import com.example.tree.ui.theme.onTertiaryLight
import com.example.tree.ui.theme.onTertiaryLightHighContrast
import com.example.tree.ui.theme.onTertiaryLightMediumContrast
import com.example.tree.ui.theme.outlineDark
import com.example.tree.ui.theme.outlineDarkHighContrast
import com.example.tree.ui.theme.outlineDarkMediumContrast
import com.example.tree.ui.theme.outlineLight
import com.example.tree.ui.theme.outlineLightHighContrast
import com.example.tree.ui.theme.outlineLightMediumContrast
import com.example.tree.ui.theme.outlineVariantDark
import com.example.tree.ui.theme.outlineVariantDarkHighContrast
import com.example.tree.ui.theme.outlineVariantDarkMediumContrast
import com.example.tree.ui.theme.outlineVariantLight
import com.example.tree.ui.theme.outlineVariantLightHighContrast
import com.example.tree.ui.theme.outlineVariantLightMediumContrast
import com.example.tree.ui.theme.primaryContainerDark
import com.example.tree.ui.theme.primaryContainerDarkHighContrast
import com.example.tree.ui.theme.primaryContainerDarkMediumContrast
import com.example.tree.ui.theme.primaryContainerLight
import com.example.tree.ui.theme.primaryContainerLightHighContrast
import com.example.tree.ui.theme.primaryContainerLightMediumContrast
import com.example.tree.ui.theme.primaryDark
import com.example.tree.ui.theme.primaryDarkHighContrast
import com.example.tree.ui.theme.primaryDarkMediumContrast
import com.example.tree.ui.theme.primaryLight
import com.example.tree.ui.theme.primaryLightHighContrast
import com.example.tree.ui.theme.primaryLightMediumContrast
import com.example.tree.ui.theme.scrimDark
import com.example.tree.ui.theme.scrimDarkHighContrast
import com.example.tree.ui.theme.scrimDarkMediumContrast
import com.example.tree.ui.theme.scrimLight
import com.example.tree.ui.theme.scrimLightHighContrast
import com.example.tree.ui.theme.scrimLightMediumContrast
import com.example.tree.ui.theme.secondaryContainerDark
import com.example.tree.ui.theme.secondaryContainerDarkHighContrast
import com.example.tree.ui.theme.secondaryContainerDarkMediumContrast
import com.example.tree.ui.theme.secondaryContainerLight
import com.example.tree.ui.theme.secondaryContainerLightHighContrast
import com.example.tree.ui.theme.secondaryContainerLightMediumContrast
import com.example.tree.ui.theme.secondaryDark
import com.example.tree.ui.theme.secondaryDarkHighContrast
import com.example.tree.ui.theme.secondaryDarkMediumContrast
import com.example.tree.ui.theme.secondaryLight
import com.example.tree.ui.theme.secondaryLightHighContrast
import com.example.tree.ui.theme.secondaryLightMediumContrast
import com.example.tree.ui.theme.surfaceBrightDark
import com.example.tree.ui.theme.surfaceBrightDarkHighContrast
import com.example.tree.ui.theme.surfaceBrightDarkMediumContrast
import com.example.tree.ui.theme.surfaceBrightLight
import com.example.tree.ui.theme.surfaceBrightLightHighContrast
import com.example.tree.ui.theme.surfaceBrightLightMediumContrast
import com.example.tree.ui.theme.surfaceContainerDark
import com.example.tree.ui.theme.surfaceContainerDarkHighContrast
import com.example.tree.ui.theme.surfaceContainerDarkMediumContrast
import com.example.tree.ui.theme.surfaceContainerHighDark
import com.example.tree.ui.theme.surfaceContainerHighDarkHighContrast
import com.example.tree.ui.theme.surfaceContainerHighDarkMediumContrast
import com.example.tree.ui.theme.surfaceContainerHighLight
import com.example.tree.ui.theme.surfaceContainerHighLightHighContrast
import com.example.tree.ui.theme.surfaceContainerHighLightMediumContrast
import com.example.tree.ui.theme.surfaceContainerHighestDark
import com.example.tree.ui.theme.surfaceContainerHighestDarkHighContrast
import com.example.tree.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.example.tree.ui.theme.surfaceContainerHighestLight
import com.example.tree.ui.theme.surfaceContainerHighestLightHighContrast
import com.example.tree.ui.theme.surfaceContainerHighestLightMediumContrast
import com.example.tree.ui.theme.surfaceContainerLight
import com.example.tree.ui.theme.surfaceContainerLightHighContrast
import com.example.tree.ui.theme.surfaceContainerLightMediumContrast
import com.example.tree.ui.theme.surfaceContainerLowDark
import com.example.tree.ui.theme.surfaceContainerLowDarkHighContrast
import com.example.tree.ui.theme.surfaceContainerLowDarkMediumContrast
import com.example.tree.ui.theme.surfaceContainerLowLight
import com.example.tree.ui.theme.surfaceContainerLowLightHighContrast
import com.example.tree.ui.theme.surfaceContainerLowLightMediumContrast
import com.example.tree.ui.theme.surfaceContainerLowestDark
import com.example.tree.ui.theme.surfaceContainerLowestDarkHighContrast
import com.example.tree.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.example.tree.ui.theme.surfaceContainerLowestLight
import com.example.tree.ui.theme.surfaceContainerLowestLightHighContrast
import com.example.tree.ui.theme.surfaceContainerLowestLightMediumContrast
import com.example.tree.ui.theme.surfaceDark
import com.example.tree.ui.theme.surfaceDarkHighContrast
import com.example.tree.ui.theme.surfaceDarkMediumContrast
import com.example.tree.ui.theme.surfaceDimDark
import com.example.tree.ui.theme.surfaceDimDarkHighContrast
import com.example.tree.ui.theme.surfaceDimDarkMediumContrast
import com.example.tree.ui.theme.surfaceDimLight
import com.example.tree.ui.theme.surfaceDimLightHighContrast
import com.example.tree.ui.theme.surfaceDimLightMediumContrast
import com.example.tree.ui.theme.surfaceLight
import com.example.tree.ui.theme.surfaceLightHighContrast
import com.example.tree.ui.theme.surfaceLightMediumContrast
import com.example.tree.ui.theme.surfaceVariantDark
import com.example.tree.ui.theme.surfaceVariantDarkHighContrast
import com.example.tree.ui.theme.surfaceVariantDarkMediumContrast
import com.example.tree.ui.theme.surfaceVariantLight
import com.example.tree.ui.theme.surfaceVariantLightHighContrast
import com.example.tree.ui.theme.surfaceVariantLightMediumContrast
import com.example.tree.ui.theme.tertiaryContainerDark
import com.example.tree.ui.theme.tertiaryContainerDarkHighContrast
import com.example.tree.ui.theme.tertiaryContainerDarkMediumContrast
import com.example.tree.ui.theme.tertiaryContainerLight
import com.example.tree.ui.theme.tertiaryContainerLightHighContrast
import com.example.tree.ui.theme.tertiaryContainerLightMediumContrast
import com.example.tree.ui.theme.tertiaryDark
import com.example.tree.ui.theme.tertiaryDarkHighContrast
import com.example.tree.ui.theme.tertiaryDarkMediumContrast
import com.example.tree.ui.theme.tertiaryLight
import com.example.tree.ui.theme.tertiaryLightHighContrast
import com.example.tree.ui.theme.tertiaryLightMediumContrast
import com.example.ui.theme.AppTypography

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun TreeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      darkTheme -> darkScheme
      else -> lightScheme
  }
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window
      window.statusBarColor = colorScheme.primary.toArgb()
      WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
    }
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

