export interface ScreenshotPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
