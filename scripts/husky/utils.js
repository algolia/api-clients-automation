import { execaCommand } from 'execa';

export async function run(command) {
  return (
    (
      await execaCommand(command, {
        shell: 'bash',
        all: true,
      })
    ).all ?? ''
  );
}
