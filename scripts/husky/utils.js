import execa from 'execa';

export async function run(command) {
  return (
    (
      await execa.command(command, {
        shell: 'bash',
        all: true,
      })
    ).all ?? ''
  );
}
